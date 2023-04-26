# Java-APP-CRUD

Prosta apliakcja CRUD do zarządzania swoimi zadaniami "To Do List". Aplikacja jest na wczesnym etapie rozwoju, będzie dalej rozwijana.

## Jak uruchomić projekt

### MySQL WorkBench
Dodajemy nowe połączenie
nazwa połącznia: MySQL Docker
metoda połączenia: Standard(TCP/IP)
ip: 127.0.0.1
port: 3306
username: root
password: root

Dodajemy bazę która jest w projekcie
z folderu "db" dodajemy "todolistlibrary_task"

### Tworzymy obraz Docker
W terminalu wpisujemy polecenia:
docker pull mysql
docker run --name todolistlibrary-mysql -e MYSQL_ROOT_PASSWROD=root -d -p 3306:3306 mysql

### Uruchamiamy projekt przez termianal w kompilatorze
mvn clean install
mvn spring-boot:run

### W przeglądarce wpisujemy adres URL
http://localhost:8080/tasks/list
