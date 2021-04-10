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