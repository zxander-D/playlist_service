# Playlist_Service

Rule: Playlist names are unique.
Rule: Song is just the name of the song.

When a playlist is created with a name
Then a confirmation is returned that it was successful.
And the playlist is empty.

When a playlist is created with existing name
Then a message is returned that it was unsuccessful.

When a playlist is created without a name
Then a message is returned that a name is required.

Given a playlist
When a song is added
Then the playlist have one more song

Given a playlist has songs
When a song is removed
Then the playlist have one less song

Given a playlist has songs
When retrieve the playlist


##Docker commands

docker build -t guestbook:dev .

Setup
docker network create --driver bridge guestbook-net
docker run --name guestbook_pg --network guestbook-net -e POSTGRES_PASSWORD=GuestsAreAwesome -e POSTGRES_DB=guestbook_db -d postgres

Run
docker run --name guestbook1 --network guestbook-net -e SPRING_PROFILES_ACTIVE=docker -e PORT=8080 -p 9000:8080 -d guestbook:dev

Postgress
docker run --name my-postgres -e POSTGRES_PASSWORD=open -e POSTGRES_DB=playlist_db -p 5432:5432 -d postgres