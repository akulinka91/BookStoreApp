package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import views.html.books.*;

import javax.inject.Inject;

public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<Book> books = Book.finder.all();

        return ok(index.render(books));
    }

    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        book.save();
        return redirect(routes.BooksController.index());
    }

    public Result edit(Integer id){
        Book book = Book.finder.byId(id);
        if (book == null){
            return notFound("Book not found");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);

        return ok(edit.render(bookForm));
    }

    public Result update(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book oldBook = Book.finder.byId(book.id);
        if (oldBook == null){
            return notFound("Book not found");
        }
        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;
        oldBook.update();
        return redirect(routes.BooksController.index());
    }

    public Result destroy(Integer id){
        Book book = Book.finder.byId(id);
        if (book == null){
            return notFound("Book not found");
        }
        book.delete();
        return redirect(routes.BooksController.index());
    }

    public Result show(Integer id){
        Book book = Book.finder.byId(id);
        if (book == null){
            return notFound("Book not found");
        }
        return ok(show.render(book));
    }
}
