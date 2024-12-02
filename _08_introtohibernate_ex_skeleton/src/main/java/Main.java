import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        // zad_2_changeTowns(entityManager);
        // zad_2_printTowns(entityManager);
        // zad_3_isEmployeeFound(entityManager);
        // zad_4_getFirstName(entityManager);
        // zad_5_getRNDemployees(entityManager);
        // zad_6_newAddress(entityManager);
        // zad_7_addressesWithEmployeeCount(entityManager);
        // zad_8_getEmployeeProjects_1(entityManager); getEmployeeProjects_2(entityManager);
        // zad_9_Find_the_Latest_10_Projects(entityManager);
        // zad_10_Increase_Salaries(entityManager);
        // zad_11_Find_Employees_by_First_Name(entityManager);
        // zad_12_Employees_Maximum_Salaries(entityManager);
        zad_13_Remove_Towns(entityManager);


        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private static void zad_13_Remove_Towns(EntityManager entityManager) throws IOException {
        System.out.print("Enter town: ");
        String townName = READER.readLine();

        int townId = entityManager
                .createQuery("FROM Town WHERE name = :name", Town.class)
                .setParameter("name", townName)
                .getSingleResult().getId();

        entityManager
                .createQuery("FROM Employee WHERE address.town.name = :townName", Employee.class)
                .setParameter("townName", townName)
                .getResultList()
                .forEach(e -> {
                    e.setAddress(null);
                    entityManager.persist(e);
                });

        List<Address> deletedAddresses = entityManager
                .createQuery("FROM Address AS a WHERE a.town.id= :id", Address.class)
                .setParameter("id", townId)
                .getResultList();

        deletedAddresses.forEach(a -> entityManager.remove(a));

        entityManager
                .createQuery("FROM Town WHERE id = :id", Town.class)
                .setParameter("id", townId)
                .getResultStream().forEach(t -> entityManager.remove(t));

        System.out.printf("%d address in %s deleted", deletedAddresses.size(), townName);
    }

    private static void zad_12_Employees_Maximum_Salaries(EntityManager entityManager) {
        List<Tuple> resultList = entityManager
                .createQuery(
                        "SELECT e.department.name AS departmentName, MAX(e.salary) as maxSalary " +
                                "FROM Employee AS e " +
                                "GROUP BY department.name " +
                                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Tuple.class)
                .getResultList();

        resultList.forEach(t -> System.out.printf("%s %.2f%n", t.get("departmentName"), t.get("maxSalary")));

        System.out.println();
        // List<Object[]>
        entityManager
                .createQuery(
                        "SELECT e.department.name, MAX(e.salary)" +
                                "FROM Employee AS e " +
                                "GROUP BY department.name " +
                                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(o -> System.out.printf("%s %.2f%n", o[0], o[1]));

        System.out.println();
        entityManager
                .createQuery("FROM Department", Department.class)
                .getResultStream()
                .forEach(d -> {
                    double maxSalary = d.getEmployees().stream().mapToDouble(e -> e.getSalary().doubleValue()).max().getAsDouble();

                    if (maxSalary < 30000 || maxSalary > 70000) {
                        System.out.printf("%s %.2f%n", d.getName(), maxSalary);
                    }
                });
    }

    private static void zad_11_Find_Employees_by_First_Name(EntityManager entityManager) throws IOException {
        System.out.print("Enter search pattern: ");
        String pattern = READER.readLine();
        entityManager
                .createQuery("FROM Employee WHERE firstName LIKE CONCAT(:pattern,'%')", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(employee -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
                });
    }

    private static void zad_10_Increase_Salaries(EntityManager entityManager) {

        entityManager
                .createQuery("FROM Employee WHERE department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList()
                .forEach(employee -> {
                    employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
                    entityManager.persist(employee);
                    System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
                });

    }

    private static void zad_9_Find_the_Latest_10_Projects(EntityManager entityManager) {

        entityManager
                .createQuery("FROM Project WHERE startDate IS NOT NULL ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(System.out::println);
    }

    private static void getEmployeeProjects_2(EntityManager entityManager) throws IOException {
        Employee emp = entityManager.find(Employee.class, Integer.parseInt(READER.readLine()));

        if (emp.getProjects().isEmpty()) {
            return;
        }

        System.out.printf("%s %s - %s%n", emp.getFirstName(), emp.getLastName(), emp.getJobTitle());

        emp.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("\t\t%s%n", project.getName()));
    }

    private static void zad_8_getEmployeeProjects_1(EntityManager entityManager) throws IOException {
        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(READER.readLine());

        entityManager
                .createQuery("FROM Employee WHERE SIZE(projects) > 0 AND id = :id", Employee.class)
                .setParameter("id", id)
                .getResultList()
                .forEach(employee -> {
                    String projectNameOrdered = employee
                            .getProjects()
                            .stream()
                            .map(Project::getName)
                            .sorted()
                            .map(name -> "      ".concat(name))
                            .collect(Collectors.joining(System.lineSeparator()));

                    //StringBuilder splitBySpace = new StringBuilder();
                    //projectNameOrdered.forEach(name->splitBySpace.append("      ").append(name).append(System.lineSeparator()));

                    System.out.printf("%s %s - %s%n%s",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getJobTitle(),
                            projectNameOrdered
                    );
                });
    }

    private static void zad_7_addressesWithEmployeeCount(EntityManager entityManager) {

        entityManager
                .createQuery("FROM Address order by size(employees) desc", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> System.out.printf("%s, %s - %d%n", a.getText(), a.getTown().getName(), a.getEmployees().size()));

    }

    private static void zad_6_newAddress(EntityManager entityManager) throws IOException {
        System.out.print("Enter employee last name: ");
        String lastName = READER.readLine();
        Address address = new Address();
        address.setText("Vitoshka 15");
        address.setTown(entityManager.createQuery("FROM Town WHERE name = 'Sofia'", Town.class)
                .getSingleResult());

        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        entityManager
                .createQuery("UPDATE Employee SET address.id = :addressId WHERE lastName = :lastName")
                .setParameter("addressId", address.getId())
                .setParameter("lastName", lastName)
                .executeUpdate();

    }

    private static void getRNDemployees(EntityManager entityManager) {
        entityManager
                .createQuery(
                        "FROM Employee " +
                                "where department.name = 'Research and Development' " +
                                "order by salary, id", Employee.class)
                .getResultList()
                .forEach(emp -> System.out.printf("%s %s from %s - $%.2f%n"
                        , emp.getFirstName()
                        , emp.getLastName()
                        , emp.getDepartment().getName()
                        , emp.getSalary()
                ));
    }

    private static void zad_4_getFirstName(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.println(employee.getFirstName()));
    }

    private static void zad_3_isEmployeeFound(EntityManager entityManager) throws IOException {

        System.out.print("Type in first and last name below: ");
        String[] names = READER.readLine().split("\\s+");

        List<Employee> resultList = entityManager
                .createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName", Employee.class)
                .setParameter("firstName", names[0])
                .setParameter("lastName", names[1]).getResultList();

        System.out.println(resultList.isEmpty() ? "No" : "Yes");
    }

    private static void zad_2_printTowns(EntityManager entityManager) {
        entityManager
                .createQuery("FROM Town", Town.class)
                .getResultList()
                .forEach(town -> System.out.println(town));
    }

    private static void zad_2_changeTowns(EntityManager entityManager) {
        entityManager.createQuery("UPDATE Town SET name = UPPER(name) WHERE LENGTH(name) > 5").executeUpdate();

        /* entityManager
                .createQuery("FROM Town WHERE length(name) > 5", Town.class)
                .getResultList()
                .forEach(town -> {
                            town.setName(town.getName().toUpperCase());
                            entityManager.persist(town);
                        }
                );
         */
    }
}
