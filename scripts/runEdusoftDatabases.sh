#docker run --restart unless-stopped -d -p 6900:5984 --net edusoft --name medewerker-database -v /usr/local/var/lib/couchdb --volumes-from edusoft-data sadema/couchdb
docker run --restart unless-stopped -d -p 6901:5984 --net edusoft --name basisregistratie-database -v /usr/local/var/lib/couchdb --volumes-from edusoft-data sadema/couchdb
