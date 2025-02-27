import http from 'k6/http';  // Correção: Importação correta do módulo HTTP
import { check, sleep } from 'k6';
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js"; // Correto

export const options = {
  stages: [{ duration: '10s', target: 10 }], // Correção: valores inteiros, não strings
  thresholds: {
    checks: ['rate > 0.95'], // Correção: lógica correta para checks bem-sucedidos
    http_req_failed: ['rate < 0.01'], // Correção: expectativa de menos de 1% de falhas
    http_req_duration: ['p(95) < 500'] // Correção: 95% das requisições em menos de 500ms
  }
};

export default function() {
  const BASE_URL = 'http://test-api.k6.io';

  const USER = `${Math.random()}@mail.com`;
  const pass = 'user123';

  const res = http.post(`${BASE_URL}/user/register`, { // Correção: URL correta e typo corrigido
    login: USER,
    password: pass
  });

  check(res, {
    'sucesso ao registrar': (r) => r.status === 201 // Correção: Mensagem ajustada para correspondência
  });

  sleep(1);
}

export function handleSummary(data) {
  return {
    "relatorio-3.html": htmlReport(data), // Certifique-se de que a função htmlReport está importada corretamente
  };
}
