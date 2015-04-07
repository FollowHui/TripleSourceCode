package controller;

/**
 * Created by Administrator on 2015/4/4.
 */


import Dao.model.Comment;
import Dao.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.BlogListService;
import service.GetAllNotesService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bloglist")
public class BlogListController {
    @Autowired(required = false)
    BlogListService blogListService;
    @Autowired
    GetAllNotesService getAllNotesService;
    @RequestMapping(value="/addmore",method = RequestMethod.GET)
    public String printWelcome(ModelMap modelMap,HttpSession httpSession) {
        int noteCount =(Integer)httpSession.getAttribute("noteCount");
        noteCount=noteCount+2;
        httpSession.setAttribute("noteCount",noteCount);
        List<Note> noteList;
        noteList=getAllNotesService.getAllNotes(noteCount);
        modelMap.addAttribute("noteList",noteList);
        return "blogList";

    }

    @RequestMapping(value="/bljump/{noteId}", method = RequestMethod.GET)
    public String getJump(@PathVariable("noteId") Integer noteId,ModelMap modelMap){
        Note note=blogListService.getNoteByNoteId(noteId);
        List<Comment> commentList=blogListService.getCommentsByNoteId(noteId);
        modelMap.addAttribute("note",note);
        modelMap.addAttribute("commentList",commentList);
        return "blogDetail";
    }
}

