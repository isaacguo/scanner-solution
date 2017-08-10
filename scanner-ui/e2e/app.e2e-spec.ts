import { ScannerNgPage } from './app.po';

describe('scanner-ng App', () => {
  let page: ScannerNgPage;

  beforeEach(() => {
    page = new ScannerNgPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
