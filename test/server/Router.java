package test.server;

import java.util.HashMap;

class Router {

	final public static String METHOD_ANY = "ANY";

	private HashMap<String, RouteMethod> routes;

	public Router(){
		routes = new HashMap<>();
	}

	public void registerRoute(String path, Route r){
		registerRoute(METHOD_ANY, path, r);
	}

	public void registerRoute(String method, String path, Route r){
		if(!routes.containsKey(path))
			routes.put(path, new RouteMethod());

		routes.get(path).put(method, r);
	}

	public void executeRoute(Request req, Response res){
		RouteMethod rm = routes.get(req.getURI().getPath());

		if(rm != null){
			Route r = rm.getRouteByMethod(req.getMethod());

			if(r != null){
				r.execute(req, res);
				return;
			}
		}

		res.setCode(404);
		res.setBody("Not found");
	}

	private class RouteMethod
	extends HashMap<String, Route> {
		public Route getRouteByMethod(String method){
			return containsKey(method) ? get(method) : get(METHOD_ANY);
		}
	}

}

