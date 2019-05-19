<h1 align="center">Automated Parking System</h1>

## Services diagram

<p align="center"> 
    <img width="600" src="./docs/services.png" alt="Services Diagram">
</p>

## Services description

1. [Parking Space Service](./01_parking_space_service/) [Java]
2. Account Service [Java]
3. Notifications Service [Java]
4. [Web Application](./04_web_application/) [JavaScript / React]
5. Parking Meter [Python]
6. [Parking Sensors](./06_parking_sensor) [Python]
7. [Parking Space Database](./07_parking_space_database) [MySQL]

## Hit the ground running

<details><summary><i>Set up project</i></summary><p>

```bash
# clone repository
git clone https://github.com/SkalskiP/WebServicesShowOff.git

# navigate to main directory
cd WebServicesShowOff
```
</p></details>

<details><summary><i>Set up and run Parking Sensor Client</i></summary><p>

```bash
# navigate to parking sensor directory
cd 06_parking_sensor

# run set up shell script
sudo sh setup_python_with_env.sh

# activate virtual environment
source .env/bin/activate

# run client
python3 parking_sensor_terminal.py
```
</p></details>

<details><summary><i>Set up Database for Parking Service</i></summary><p>

1. Install MySQL on your system
2. Create Database and run provided SQL script
3. Set up MySQL on Application Server
4. Add datasource to your application server with JNDI name java:/PARKING_SPACE
5. Profit

</p></details>

## Parking Sensor SOAP Client

<p align="center"> 
    <img width="600" src="./docs/parking_sensor_mock.gif" alt="Services Diagram">
</p>

## Parking Space Database diagram

<p align="center"> 
    <img width="600" src="./docs/parking_space_database.png" alt="Services Diagram">
</p>
