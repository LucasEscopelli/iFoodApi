package com.lucas.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.api.domain.modelo.Permissao;
import com.lucas.domain.repository.PermissaoRepository;

@Component
public class CidadeRepositoryImp implements PermissaoRepository{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> listar() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}
	
	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Transactional
	@Override
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}
	
	@Transactional
	@Override
	public void remover(Permissao permissao) {
		permissao = this.buscar(permissao.getId());
		manager.remove(permissao);
	}
}
