package by.tc.parsing.controller;

import by.tc.parsing.controller.util.ListOutputHelper;
import by.tc.parsing.controller.util.Paginator;
import by.tc.parsing.controller.validator.PageParamValidator;
import by.tc.parsing.dao.parse.CommandName;
import by.tc.parsing.entity.Flower;
import by.tc.parsing.service.FlowerService;
import by.tc.parsing.service.ServiceFactory;
import by.tc.parsing.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 19.11.2017.
 */
public class FrontController extends HttpServlet {
    private static final Logger Logger = LogManager.getLogger(FrontController.class);
    private static final long serialVersionUID = -1058916453755543319L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory instance = ServiceFactory.getInstance();
        FlowerService flowerService = instance.getFlowerService();

        String commandParam = req.getParameter("command");

        if (commandParam != null && CommandName.isContainsCommand(commandParam)) {
            try {
                List<Flower> allFlowers = flowerService.parse(commandParam);
                String pageParam = req.getParameter("page");
                if (PageParamValidator.isValidPageParam(pageParam,ListOutputHelper.getNumberPages(allFlowers.size()))) {
                    int currentPage = Integer.parseInt(pageParam);

                    Paginator paginator = new Paginator(allFlowers.size(), currentPage);

                    List<Flower> outPutFlowers = allFlowers.subList(ListOutputHelper.indexFirstElementOnPage(currentPage),
                            ListOutputHelper.getIndexLastElementOnPage(paginator.getContentSize(), currentPage));

                    req.setAttribute("currentPage", currentPage);
                    req.setAttribute("nextPage", paginator.getNextPage());
                    req.setAttribute("prevPage", paginator.getPreviousPage());
                    req.setAttribute("lastPage", paginator.getLastPage());
                    req.setAttribute("firstPage", paginator.getFirstPage());
                    req.setAttribute("flowerList", outPutFlowers);
                    req.setAttribute("command", commandParam);
                    req.getRequestDispatcher("WEB-INF/flowersInfo.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, resp);
                }
            } catch (ServiceException e) {
                Logger.error(e);
            }
        } else {
            req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
