package test.server;

class TestAPI extends Router {

	public TestAPI(){
		super();

		registerRoute("/", new Route(){
			public void execute(Request req, Response res){
				res.setBody("Call successful");
			}
		});

		registerRoute("/ping", new Route(){
			public void execute(Request req, Response res){
				res.setBody("pong");
			}
		});

		registerRoute("POST", "/washington", new Route(){
			public void execute(Request req, Response res){
				res.setBody("You gave me this:\n");
				res.appendBody(req.getBody());
			}
		});
	}

}

