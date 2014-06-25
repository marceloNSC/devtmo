package br.carnaval.model.dao.impl;

import br.carnaval.bean.Ala;
import br.carnaval.bean.Fantasia;
import br.carnaval.bean.Foliao;
import br.carnaval.model.conexao.Conexao;
import br.carnaval.model.dao.FoliaoDao;

public class Main {

	public static void main(String[] args) {

		Foliao foliao = new Foliao();
		foliao.setIdade(28);
		foliao.setNome("brunoro montevintel");
		foliao.setCpf(5333587);
		foliao.setRg(65657678);

		FoliaoDao foliaoimp = new ImplFoliao(Conexao.getInstance());
		foliaoimp.save(foliao);

		Fantasia fantasia = new Fantasia();
		fantasia.setNomeFantasia("cavaleior do mar");
		fantasia.setPesoFantasia(251);
		fantasia.setUrlImagem("url pra fazer upload da imagens");

		Ala ala = new Ala();
		ala.setNomeAla("conversação dos malandros");
		ala.setNumeroIntegrantes(250);

		
		
		
		
	}

}
