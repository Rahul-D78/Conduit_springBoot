## This is a blogging application builld using SpringBoot :

## Technologis used :
1. SpringBoot
2. Java
3. Hibernate
4. PostgreSQL
5. Maven
6. SpringBoot Security

## Database Setup :

```$sudo -i -u postgres```

Enter `psql` as admin.

```$psql```

```SQL
CREATE DATABASE conduit;

CREATE USER conduit WITH ENCRYPTED PASSWORD 'conduit';

GRANT ALL PRIVILEGES ON DATABASE conduit TO conduit;
```
