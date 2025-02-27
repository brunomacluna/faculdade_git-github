import { chromium } from 'k6/experimental/browser';
import { sleep } from 'k6';
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";


export default async function () {
  const browser = chromium.launch({ headless: false });
  const page = browser.newPage();

  try {
    await page.goto('https://mywebsite.com');

    await page.waitForSelector('p[class="woocommerce-result-count"]');
    await page.screenshot({ path: 'screenshots/01_homepage.png' });

    sleep(4);

    const element = page.locator(
      'a[class="woocommerce-LoopProduct-link woocommerce-loop-product__link"]'
    );

    await element.click();
    await page.waitForSelector('button[name="add-to-cart"]');
    await page.screenshot({ path: 'screenshots/02_view-product.png' });
  } finally {
    await page.close();
    await browser.close();
  }
}

export function handleSummary(data) {
  return {
    "relatorio-teste-front-1.html": htmlReport(data),
  };
}



