import { TestBed, inject } from '@angular/core/testing';

import { MovimentacaoService } from './movimentacao.service';

describe('MovimentacaoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MovimentacaoService]
    });
  });

  it('should ...', inject([MovimentacaoService], (service: MovimentacaoService) => {
    expect(service).toBeTruthy();
  }));
});
