

## Dokumentacja API

Przykład dokumentacji API, serwis komunikuje się za pomocą HTTP, dane przekazywane w formacie JSON

### Endpoint
|Name|Value|
|-|-|
|Url|v1/token/generate|
|Method|GET|
|Params|none|

Body:
```javascript
none
```
Response:
```javascript
{  
 "token":"74d51edd-3767-433d-9a91-1bc970904022"  
}
```

### Endpoint
|Name|Value|
|-|-|
|Url|v1/sample/save|
|Method|POST|
|Params|none|

Body: 
```javascript
{  
 "token":"74d51edd-3767-433d-9a91-1bc970904022",  
 "occuredOn":"2017-07-03T22:02:56.525+05:30",  
 "finishedOn":"2017-07-03T23:02:56.525+05:30",  
 "count":124124  
}
```
Response:
```javascript
code:200
```

### Endpoint
|Name|Value|
|-|-|
|Url|v1/score/top|
|Method|GET|
|Params|```"token":"74d51edd-3767-433d-9a91-1bc970904022","count":10```|

Body:
```javascript
none
```
Response:
```javascript
[  
 {  
  "idDevice":"432423423",  
  "score":"4323"  
 }  
]
```

### Endpoint
|Name|Value|
|-|-|
|Url|v1/score/my|
|Method|GET|
|Params|```"token":"74d51edd-3767-433d-9a91-1bc970904022"```|

Body:
```javascript
none
```
Response:
```javascript
{  
 "idDevice":"432423423",  
 "score":"4323"  
}
```
