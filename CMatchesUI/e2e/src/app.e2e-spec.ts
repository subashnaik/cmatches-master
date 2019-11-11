import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';

describe('CMatch App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display title of application', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('CMatchesUI');    
  });

  it('should be redirected to register page', () =>{
    browser.element(by.css('.register-button')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
    browser.driver.sleep(2000);
  });

  it('should be able to register user', () => {
    browser.element(by.id('userId')).sendKeys('naresh');
    browser.element(by.id('userPassword')).sendKeys('pass');
    browser.element(by.id('firstName')).sendKeys('Naresh');
    browser.element(by.id('email')).sendKeys('naresh@gmail.com');
    browser.element(by.css('.register-user')).click();
    browser.driver.sleep(2000);
  });

  it('should be able to login user', () => {
    browser.element(by.id('userId')).sendKeys('naresh');    
    browser.element(by.id('userPassword')).sendKeys('pass');
    browser.element(by.css('.login-click')).click();
    browser.driver.sleep(2000);
  });

  it('should be able to click on Menu item for Current Cricket Matches', () => {
    browser.element(by.css('.mat-button')).click();
    browser.driver.sleep(1000);
    browser.element(by.css('.mat-menu-item-current')).click();
    expect(browser.getCurrentUrl()).toContain('/current');   
    browser.driver.sleep(1000); 
  });  

  it('should be able to save current match to favourite list', () => {
    browser.driver.manage().window().maximize();    
    browser.driver.sleep(1000);
    browser.element(by.css('.addbutton')).click();
    browser.driver.sleep(1000);
  });  

  it('should be able to click on Menu item for Old Cricket Matches', () => {
    browser.element(by.css('.mat-button')).click();
    browser.driver.sleep(1000);
    browser.element(by.css('.mat-menu-item-old')).click();
    expect(browser.getCurrentUrl()).toContain('/old');   
    browser.driver.sleep(1000); 
  });  

  it('should be able to save old match to favourite list', () => {
    browser.driver.manage().window().maximize();    
    browser.driver.sleep(1000);
    browser.element(by.css('.addbutton')).click();
    browser.driver.sleep(1000);
  });  

  it('should be able to get all favourite matches', () => {    
    browser.driver.sleep(1000);
    browser.element(by.css(".mat-button-favourite")).click();
    expect(browser.getCurrentUrl()).toContain("favouritematches");
    browser.driver.sleep(1000);
  });  

  it('should be able to delete data from favourite list', () => {    
    browser.driver.sleep(1000);
    browser.element(by.css(".deletebutton")).click();    
    browser.driver.sleep(1000);
  });  

  it('should be able to get all data from recommendaton list', () => {    
    browser.driver.sleep(1000);
    browser.element(by.css(".mat-button-recommend")).click();
    expect(browser.getCurrentUrl()).toContain("recommendedmatches");
    browser.driver.sleep(1000);
  });

  it('should be able to logout from application', () => {
    browser.driver.sleep(500);
    browser.element(by.css('.mat-button-logout')).click();
    browser.driver.sleep(500);
  });

});
