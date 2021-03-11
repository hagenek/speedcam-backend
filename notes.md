# Notes while doing the Teleplan Globe NORA assignment.

Assignment start:

## Issues with Clojure Backend

Using lib Environ surprisingly fraught with issues.
May resort to using (System/getenv "VAR") having seperate production and dev builds...

## Mongo DB import JSON file to DB.

Trying the import tool, ie. the MongoDB CLI. Added it to path.
It is not the MongoDB CLI but another set of Database tools.
Used mongoimport tool to transfer the json file into my mongodb in the cloud.
Then used monger to get a clojure map from the database, turning this into json again to serve to the frontend.

## JS Frontend

Frontend working with backend showing cameras at correct position @ 14:33.
