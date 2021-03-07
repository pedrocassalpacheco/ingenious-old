curl -X POST \
  http://localhost:8080/products \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{'product': 'APM'}'
