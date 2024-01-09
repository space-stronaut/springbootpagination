package com.belajar.spring.service;

import com.belajar.spring.dto.LimitDTO;
import com.belajar.spring.repository.UserRepository;
import com.belajar.spring.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/user/paginate")
    public ResponseEntity<?> gUserPaginate(@RequestBody LimitDTO request) throws Throwable{
        try{
            int totalData = request.getPage() * request.getLimit() - request.getLimit();
            Response response = new Response();
            response.setCurrentPage(request.getPage());
            response.setRowPerPage(request.getLimit());
            response.setTotalPage((int) userRepository.count() / request.getLimit());
            response.setData(userRepository.gPaginateUser(request.getLimit(), totalData));
            return ResponseEntity.status(200).body(response);
        }catch (Exception e){
            throw e.fillInStackTrace();
        }
    }
}
