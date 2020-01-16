# java3-project

course project --- TruthHub

Description: 
  create a website for users to post footage videos, which record an event (accident, criminal...etc) with datetime and location. so that   the footage can be retrieved by public and related interest party (victims, law-enforcement etc)

Schema name in mySQL workbench: truth_hub

Tables: footage and publisher 

footage table: 
  columns: id, title, time, location, publisherId PK: id FK: publisherId

publisher table: 
  columns: id, username, country, footageId PK: id

Table Relations: 
  one to many: one publisher can post many footages

Future Plan:

  coordinate and embeded with google map or bing map to show the footages on map locations for example, when zoom the map into city of       dorval, it will show dorval currently has 168 posted footages, with tile info. if it forther zoom-in to street level, the posted           footages will follow accordingly into the street level. we can borrow the idea and technology of realtor.ca to show the listings in an     area.

  Develope TruthHub mobile app
