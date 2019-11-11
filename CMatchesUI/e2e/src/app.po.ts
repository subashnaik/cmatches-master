import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }

  navigateToLoginView() {
    return browser.get("/login") as Promise<any>;
  }

  navigateToCurrentMatchView() {
    return browser.get("/currentmatches") as Promise<any>;
  }
}
