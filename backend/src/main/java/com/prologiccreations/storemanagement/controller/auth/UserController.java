package com.prologiccreations.storemanagement.controller.auth;

import com.prologiccreations.storemanagement.controller.super_classes.CrudController;
import com.prologiccreations.storemanagement.dto.Response;
import com.prologiccreations.storemanagement.model.auth.User;
import com.prologiccreations.storemanagement.service.super_classes.auth.UserService;
import com.prologiccreations.storemanagement.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("user/")
public class UserController implements CrudController<User, Long> {
    private final UserService userService;

    @Override
    public ResponseEntity<Response> storeData(User data) {
        Response response = userService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<User>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<User>> response = userService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<User>> getOne(Long id) {
        Response<User> response = userService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = userService.delete(id);
        return ResponseEntity.ok(response);
    }
}
