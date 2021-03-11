# Backend for speedcam location data in Norway

## Deployed at:

https://quiet-wildwood-47347.herokuapp.com/

## Running Locally

Make sure you have Clojure installed. Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/hagenek/speedcam-backend.git
$ cd speedcam-backend
$ lein repl
user=> (require 'checklist.web)
user=>(def server (checklist.web/-main))
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

```sh
$ heroku create
$ git push heroku main
$ heroku open
```

or

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Documentation

Routes:
