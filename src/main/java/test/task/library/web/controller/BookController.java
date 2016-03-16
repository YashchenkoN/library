package test.task.library.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.task.library.dto.BookDTO;
import test.task.library.dto.GenreDTO;
import test.task.library.entity.Book;
import test.task.library.service.BookService;
import test.task.library.service.GenreService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikolay Yashchenko
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    @Qualifier("bookDTOValidator")
    private Validator validator;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Long id) {
        // todo
        return "";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        List<GenreDTO> genreDTOs = genreService.getAll().stream()
                .map(g -> conversionService.convert(g, GenreDTO.class))
                .collect(Collectors.toList());
        model.addAttribute("genres", genreDTOs);
        model.addAttribute("bookDTO", new BookDTO());
        return "book-add";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookDTO") BookDTO bookDTO) {
        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "bookDTO");
        validator.validate(bookDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/book/add";
        }

        Book book = conversionService.convert(bookDTO, Book.class);
        book = bookService.create(book);

        return "redirect:/book/" + book.getId();
    }
}
