package ru.gb.HomeWorks_core3.lesson2;

import java.sql.*;

public class HomeWorkApp {

    /**
     * DML - работата с базой данных. Команды напрвлены на работу с данными.
     * <p>
     * DDL - Работа со структурой. Команды направлены на работу с базой.
     * <p>
     * CRUD - операции - INSERT(CREATE), SELECT(READ), UPDATE, DELETE - операции с данными.
     * <p>
     * Соединения (JOIN) - операция, позволяющая соединять строки из 2-х и более таблиц на
     * основе связанного между ними столбца. (Пишется оператор ON и затем какие значения в
     * столбцах должны быть идентичны у двух обьединяемых таблиц)
     * <p>
     * Уникальный ключ (ID) нужен для поиска строки (ID - не повторяются). Структура данных
     * при создании уникаьного ключа - БИНАРНОЕ ДЕРЕВО.
     */

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {

            statement.execute("CREATE TABLE IF NOT EXISTS shorts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "score INTEGER)");

/*
            for (int i = 0; i < 10; i++) {
                String name = String.format("Alex_%d", i);
                statement.execute(String.format("INSERT INTO shorts (name, score) VALUES ('%s', %d)", name, i * 18));
            }
*/
            statement.executeUpdate(String.format("INSERT INTO shorts (name, score) VALUES ('%s', %d)", "Vova", (99 * 18)));

            ResultSet resultSet = statement.executeQuery("SELECT * FROM shorts");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("name") + " " + resultSet.getString(3));
            }


            //Добавить единичную строку
//            statement.execute("INSERT INTO students (id, name, score) VALUES (1, 'Alex', 4)");

            //Перезаписать значение в ячейке всех строк
//            statement.execute("UPDATE students SET score = 100");

            //Удалить таблицу students
//            statement.execute("DELETE from students");

            //Удаление таблицы с проверкой, если такая существуюет
//            statement.execute("drop table if exists students");

            //Создание таблицы с проверкой, если такой не существует. добавление столбцов id, name, score. Добавление автоинкремента в id
//            statement.execute("CREATE TABLE IF NOT EXISTS students (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "name TEXT," +
//                    "score INTEGER)");



/*            long time = System.currentTimeMillis();

            //Приостанавливаем сохранение состояний таблицы после каждого запроса.
            connection.setAutoCommit(false);

            for (int i = 0; i < 1000; i++) {
                String name = String.format("Alex_%d", i);
                statement.execute(String.format("INSERT INTO students (name, score) VALUES ('%s', 4)", name));
            }

            //Возобнавляем сохранение остояния таблицы после всех запросов.
            connection.setAutoCommit(true);

            System.out.println(System.currentTimeMillis() - time);*/


/*            //Если запрос в таблицу содержит текст введенный пользователем, то надо обезопаситься от иньекций.
            //Параметризация
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
            preparedStatement.setString(1, "Bob");
            preparedStatement.setInt(2, 3);

            preparedStatement.execute();*/


/*            //Селект запрос в БД
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("name") + " " + resultSet.getInt(3));
            }*/




            //комплексное добавление записей в таблицу
/*            long time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 0; i < 500; i++) {
                String name = String.format("Alex_%d", i);
                String sql = String.format("INSERT INTO students (name, score) VALUES ('%s', 4)", name);
                statement.addBatch(sql);
            }

            statement.executeBatch();
            connection.setAutoCommit(true);
            System.out.println(System.currentTimeMillis() - time);*/



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Java\\GeekBrains_HomeWork\\src\\main\\java\\ru\\gb\\HomeWorks_core3\\lesson2\\students.db");
        connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\ru\\gb\\HomeWorks_core3\\lesson2\\students.db");
        statement = connection.createStatement();
        DatabaseMetaData db = connection.getMetaData();
    }

    private static void disconnect() throws SQLException {

        connection.close();

    }
}
