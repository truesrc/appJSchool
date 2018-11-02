package ru.azoft.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.azoft.Exception.UserNotFoundException;
import ru.azoft.domain.User;
import ru.azoft.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserCtrl {

    private final UserRepository userRepository;


    private Logger logger = Logger.getLogger(UserCtrl.class);

    @Autowired
    public UserCtrl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Here we have RESTfull api from POST request "/users" we save user
     *
     * @param user
     * @return Save the user from index.jsp
     */

    @PostMapping
    public ModelAndView saveUser(@RequestBody User user ) {
        logger.info(user);
        userRepository.save(user);
        return new ModelAndView("forward:/");
    }


    /**
     * From get request GET "/users" we get user in json data format
     * Get all users for users.jsp
     *
     * @return
     */
    @GetMapping(produces = "application/json")
    public List<User> dBUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }


    /**
     * From request GET "/users" we get new view users.jsp
     * Get all users for users.jsp
     *
     * @return
     */
    @GetMapping
    public ModelAndView restUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return new ModelAndView("users", "user", list);
    }

    /**
     * From request GET "/users/{id}" we get new view edit.jsp
     *
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView dBUsersById(@PathVariable int id) {
        User user = userRepository.findOne(id);
        return new ModelAndView("edit", "user", user);
    }


    /**
     * From request GET "/users/{id}" we get find user in json data format
     *
     * @return
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public User jsonDbUsersById(@PathVariable int id) {
        return userRepository.findOne(id);
    }


    /**
     * From request DELETE "/users/{id}" we delete user by id
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        logger.info(id);
        userRepository.delete(id);
    }


    /**
     * From request PUT "/users/{id}" we update user
     *
     * @return
     */
    @PutMapping("/{id}")
    public void editUser(@RequestBody User user) {
        validateUser(user.getId());
        userRepository.save(user);
    }


    private void validateUser(int userId) {
        if (userRepository.findOne(userId) == null)
            throw new UserNotFoundException(userId);

    }

}

