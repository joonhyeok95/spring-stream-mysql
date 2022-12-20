# 1. 소스코드 소개
280만건 데이터를 화면에 뿌릴 때 stream 방식으로 테스트하는 샘플

# 2. 데이터베이스 세팅
## 2-1. mysql 대용량 샘플 데이터
https://github.com/datacharmer/test_db  
위 깃허브사이트에서 데이터를 받아 사용했다.

## 2-2. Docker Run (mysql)
```
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=admin1234 -d -p 3306:3306 mysql:latest
$ docker cp ./test_db-master mysql:/

$ docker exec -it mysql /bin/bash

bash-4.4# ls
bin  boot  dev  docker-entrypoint-initdb.d  entrypoint.sh  etc  home  lib  lib64  media  mnt  opt  proc  root  run  sbin  srv  sys  test_db-master  tmp  usr  var

bash-4.4# cd test_db-master/  

bash-4.4# ls
Changelog      employees_partitioned.sql      load_departments.dump   load_employees.dump  load_salaries3.dump  sakila            test_employees_md5.sql
README.md      employees_partitioned_5.1.sql  load_dept_emp.dump      load_salaries1.dump  load_titles.dump     show_elapsed.sql  test_employees_sha.sql
employees.sql  images                         load_dept_manager.dump  load_salaries2.dump  objects.sql          sql_test.sh       test_versions.sh
bash-4.4# mysql -u root -p < employees.sql
Enter password:
```

## 2-3. Table 확인
```
$ mysql -u root -p

show databases; 
use employees;
show tables;
```

# 3. 컨트롤러
## 3-1. GET /ori
  기본적인 select -> view 로직
## 3-2. GET /stream
  select 한걸 ResponseBodyEmitter 로 보내는 로직
