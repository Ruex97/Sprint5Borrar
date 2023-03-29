package controllers;

import model.domain.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class FlowerController {


    private WebClient webClient;

    public FlowerController() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:9001").build();
    }



    @GetMapping("/getAll")
    public ResponseEntity<Flux<Flower>> getAllFlowers() {
         Flux<Flower> flowers =   webClient.get().uri("/flower/getAll")
                    .retrieve()
                    .bodyToFlux(Flower.class);

         return new ResponseEntity(flowers, HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Mono<Flower>> getFlowerById(@PathVariable long id) {

        Mono<Flower> flower = webClient.get().uri("http://localhost:9001/flower/getOne/{id}", id)
                .retrieve()
                .bodyToMono(Flower.class);

        return new ResponseEntity(flower, HttpStatus.OK);

    }

    // add
    // getById
    // delete
    // update

}
