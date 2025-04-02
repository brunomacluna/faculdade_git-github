import { chromium } from 'k6/experimental/browser'; 
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";

export const options = {
  vus: 1,
  duration: '5s'
};

export default async function () {
  const browser = chromium.launch({ headless: true });
  const context = browser.newContext();
  const page = context.newPage();

  try {
    await page.goto('https://test.k6.io/my_messages.php', { waitUntil: 'networkidle' });

    await page.locator('input[name="login"]').type('admin');
    await page.locator('input[name="password"]').type('123');

    await page.screenshot({ path: 'screenshot.png' });
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
