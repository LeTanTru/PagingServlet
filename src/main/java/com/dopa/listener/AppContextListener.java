package com.dopa.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
	}
}
