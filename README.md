# YouTube Search Microservice for "Juke Joint"
<br>

## Communication Requirements:
There is a singular REST API endpoint that has been exposed to you. The communication medium will be HTTP and JSON will be the format. It has been deployed to an AWS EC2 instance and should have 100% uptime so you can call it whenever you want.


### Searching for a YouTube video:

#### (POST) http://54.188.27.139/youtube/search

<br>

Make an HTTP POST request to the url above containing the Song Name and Artist Name as Strings in a JSON. You will be returned a YouTube URL as a JSON String.

Example request (must use same key names but order does not matter):
```
{
  "songName": "Early Summer",
  "artistName": "Ryo Fukui"
}
```


Example response:
```
{
  "url": "https://www.youtube.com/watch?v=F5EFsUU7RRA"
}
```

The idea is that this microservice abstracts away all the complexities of setting up a YouTube API key and making the request to the YouTube API. You should only have to worry about the logic of how to get the Artist Name and Track Name into your request and how to handle the YouTube URL from the response
(e.g. embed into an iframe element).


Below is a sequence diagram of how your application would interact with this microservice and how my microservice
handles the searching of a YouTube video by communicating with the YouTube servers on your behalf.




![](https://github.com/hc-lee/youtube-search-microservice/blob/main/image.png)
