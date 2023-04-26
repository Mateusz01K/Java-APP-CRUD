# Java-APP-CRUD

Prosta apliakcja CRUD do zarządzania swoimi zadaniami "To Do List". Aplikacja jest na wczesnym etapie rozwoju, będzie dalej rozwijana.

## Jak uruchomić projekt

### MySQL WorkBench
Dodajemy nowe połączenie<br>
nazwa połącznia: MySQL Docker<br>
metoda połączenia: Standard(TCP/IP)<br>
ip: 127.0.0.1<br>
port: 3306<br>
username: root<br>
password: root<br>

Dodajemy bazę która jest w projekcie<br>
z folderu "db" dodajemy "todolistlibrary_task"

### Tworzymy obraz Docker
W terminalu wpisujemy polecenia:<br>
docker pull mysql<br>
docker run --name todolistlibrary-mysql -e MYSQL_ROOT_PASSWROD=root -d -p 3306:3306 mysql

### Uruchamiamy projekt przez termianal w kompilatorze
mvn clean install<br>
mvn spring-boot:run

### W przeglądarce wpisujemy adres URL
http://localhost:8080/tasks/list
