package cursoSpringBoot.controllers;
// implementación de una API REST
import cursoSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerRestController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer(001, "Ana Morales", "AnaM", "am123"),
            new Customer(002, "Hugo Marín", "HugoM", "hm456"),
            new Customer(003, "Borja Reyes", "BorjaR", "br789"),
            new Customer(004, "Miriam Ramos", "MiriamR", "mr147")

    ));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>>getCustomers() {

        return ResponseEntity.ok(customers);
        //return customers;
    }
    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {

                return ResponseEntity.ok(c);
                //return c;
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
        //return null;
    }
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer) {
        customers.add(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente: " + customer.getName());
        //return customer;
    }
    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                //return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getID());
                //para simplificar respuesta, que es como normalmente se hace para dar respuesta ok con codigo 204
                return ResponseEntity.noContent().build();
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getID());
        //aquí lo mismo que con la respuesta ok, pero con la respuesta 404
        return ResponseEntity.notFound().build();
    }
    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteCliente(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);

                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado satisfactoriamente: " + c.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: " + id);
    }
    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchCliente (@RequestBody Customer customer){
        for (Customer c : customers){
            if(c.getID() == customer.getID()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());


                }
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + customer.getID());
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: " + customer.getID());
    }

}