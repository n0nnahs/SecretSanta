# SecretSanta

## About The Project
`// TODO: :)`

## Manual "Deployment" Using DigitalOcean
For the purposes of this project, you can deploy this repo to a single DigitalOcean droplet to host it. After you [create a new Droplet](https://cloud.digitalocean.com/droplets/new), connect to it and run through the following setup!

### Setting up & Running the API and Database
```bash
# install git, & grab the project
$ sudo apt update
$ sudo apt install git-all
$ git clone https://github.com/n0nnahs/SecretSanta.git secret-santa
$ cd secret-santa

# Install Postgres, & configure the default postgres user
$ sudo apt install postgresql postgresql-contrib
$ psql -U postgres
> \password   # Set the postgres user's password, we'll need to fill this in later for the `application.properties` file
> CREATE DATABASE secretsanta;  # Should return `CREATE DATABASE` if successful
> \q
$ sudo nano /etc/postgresql/12/main/pg_hba.conf   # change postgres user's authentication method from "peer" to "md5"
$ sudo service postgresql restart
# Run the seedscript
$ psql -U postgres -d secretsanta -f ./SecretSantaServer/createdb.sql

# Install Java&Maven, then do some quick configuration & finally compile the server project
$ sudo apt install default-jdk maven
$ cd SecretSantaServer/

# We need to configure a new application.properties file, since our application isn't using the development database settings
#   Run the following command to remove the default application.properties
$ rm ./src/main/resources/application.properties
# Next we'll make a copy of the application.example.properties file, and edit it to
#   set the username to `postgres`, and the password to what was entered above
$ cp ./src/main/resources/application.example.properties
$ nano ./src/main/resources/application.properties

# Finally, we can run the server: 🤞
$ mvn spring-boot:run
```

If it looks like it's working, congrats! 🎉 You can kill the server with **Ctrl+C**. Next time you want to run it, you can use `screen -S santa_api -dm mvn spring-boot:run`. The new `screen` part runs the command in the background!

### Setting up & Running the Web project
```bash
# install node&npm, & install the dependencies for the client project
$ sudo apt install nodejs npm
$ cd client && npm install
# Run the project: 🤞
$ npm run start:web
```

The web project should start! If it appears that port 80 is already in use, you may have do disable Apache, which runs on some Linux distros by default. To kill it on Ubuntu, you can run `sudo systemctl disable apache2 && sudo systemctl stop apache2` to stop it & disable it from running on startup.

Same as before, you could do something like `screen -S santa_web -dm npm run start:web` next time, to have the client app run in the background. You could also choose to run these processes at startup!

---
