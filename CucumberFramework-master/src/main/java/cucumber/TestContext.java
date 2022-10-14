package cucumber;

import managers.DriversManager;
import managers.PageObjectManager;
import managers.DriversManager;

public class TestContext {
	private DriversManager driversManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	public TestContext(){
		driversManager = new DriversManager();
		pageObjectManager = new PageObjectManager(driversManager.getDriver());
		scenarioContext = new ScenarioContext();
	}
	
	public DriversManager getWebDriverManager() {
		return driversManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
