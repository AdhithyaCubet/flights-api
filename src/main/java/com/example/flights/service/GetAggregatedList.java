package com.example.flights.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.flights.model.Business;
import com.example.flights.model.BusinessData;
import com.example.flights.model.Cheap;
import com.example.flights.model.CheapData;
import com.example.flights.model.Data;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class GetAggregatedList {
	@Autowired
	@Qualifier("cheapClient")
	WebClient cheapClient;

	@Autowired
	@Qualifier("businessClient")
	WebClient businessClient;
	private static final Logger LOGGER = LoggerFactory.getLogger(GetAggregatedList.class);

	public Mono<List<Data>> getDataList() {

		return Mono.zip(cheapData(), businessData()).flatMap(t -> {
			List<Data> listData = new ArrayList<Data>();
			t.getT1().getData().ifPresent(listCheapData -> {
				listCheapData.forEach(c -> {
					listData.add(getDataT2(c));
				});
			});

			t.getT2().getData().ifPresent(listBusinessData -> {
				listBusinessData.forEach(b -> {
					listData.add(getDataT1(b));
				});
			});
			Collections.sort(listData, Data.DataComparator);
			return Mono.just(listData);

		}

		).subscribeOn(Schedulers.parallel()).onErrorResume(t -> {
			LOGGER.info("Error" + t.getMessage());

			return Mono.empty();
		});

	}

	public Data getDataT1(BusinessData bData) {
		return new Data(bData.getDeparture().orElse(""), bData.getArrival().orElse(""),
				bData.getArrivalTime().orElse(new Long(0)), bData.getDepartureTime().orElse(new Long(0)));
	}

	public Data getDataT2(CheapData cData) {
		return new Data(cData.getRoute().orElse("").split("-")[0], cData.getRoute().orElse("").split("-")[1],
				cData.getArrival().orElse(new Long(0)), cData.getDeparture().orElse(new Long(0)));
	}

	public Mono<Cheap> cheapData() {
		return cheapClient.get().retrieve().bodyToMono(Cheap.class).

				log().onErrorResume(t -> {
					LOGGER.info("Error" + t.getMessage());
					return Mono.empty();
				});
	}

	public Mono<Business> businessData() {
		return businessClient.get().retrieve().bodyToMono(Business.class).log().onErrorResume(t -> {
			System.out.println("Error" + t.getMessage());
			return Mono.empty();
		});
	}

}