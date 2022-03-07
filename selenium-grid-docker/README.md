# selenium-grid-docker

Start grid with 1 chrome and firefox node `docker-compose up`

## Running tests

Create a `RemoteWebDriver` and pass it the URL of your localhost. e.g.:
`driver = new RemoteWebDriver(new URL("http://localhost:4444"), capability);`
Where `capability` is a DesiredCapabilities object for RemoteWebDriver. It is here we set browser type (e.g. firefox or chrome) etc. I'm not providing code
right now, because I think the "DesiredCapabilities" concept is out of date. It's something similar though.

## Scaling 
The nodes can be scaled by starting multiple containers:

`docker-compose up --scale chrome=4 --scale firefox=4`

1 node per container is considered best practice but can be increased by passing in environment variables:
 
`docker-compose up -e NODE_MAX_INSTANCES=4 -e NODE_MAX_SESSION=4`