package com.raj.shashi.spring.vertx;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * @author rajs
 *
 */
@Component
public class SimpleVertx extends AbstractVerticle {

	@Override
	public void start(Future<Void> fut) throws Exception {
		Vertx vertx = Vertx.factory.vertx();

		Router router = Router.router(vertx);

		router.post("/user").handler(this::createUser);

		router.get("/user").handler(this::getUser);

		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080),
				result -> {
					if (result.succeeded()) {
						fut.complete();
					} else {
						fut.fail("it failed");
					}
				});
	}

	private void getUser(RoutingContext routingContext) {
		User user = new User();
		user.setGender("Male");
		user.setName("shashi raj");
		HttpServerResponse res = routingContext.response();

		res.setStatusCode(200).putHeader("content-type", "application/json").end(user.toString());
	}

	private void createUser(RoutingContext routingContext) {
		// ObjectMapper mapper = new ObjectMapper();
		// User user = mapper.convertValue(routingContext.getBodyAsJson(),
		// User.class);
		// dao.createUser(user);
		HttpServerResponse res = routingContext.response();
		res.setStatusCode(201).putHeader("content-type", "application/json").end();

	}
}
