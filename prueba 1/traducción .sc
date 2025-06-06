+ String {

	vocales{
		var vocales;
		vocales = this.select({ arg item; item.isVowel });
		^vocales
	}

	formantes{|registro "bajo"|
		var dic, formantes, vocales;
		(
			dic = Dictionary.new;
			dic.add("sopranoA" -> FormantTable.get(\sopranoA));
			dic.add("sopranoE" -> FormantTable.get(\sopranoE));
			dic.add("sopranoI" -> FormantTable.get(\sopranoI));
			dic.add("sopranoO" -> FormantTable.get(\sopranoO));
			dic.add("sopranoU" -> FormantTable.get(\sopranoU));

			dic.add("altoA" -> FormantTable.get(\altoA));
			dic.add("altoE" -> FormantTable.get(\altoE));
			dic.add("altoI" -> FormantTable.get(\altoI));
			dic.add("altoO" -> FormantTable.get(\altoO));
			dic.add("altoU" -> FormantTable.get(\altoU));

			dic.add("contraTenorA" -> FormantTable.get(\counterTenorA));
			dic.add("contraTenorE" -> FormantTable.get(\counterTenorE));
			dic.add("contraTenorI" -> FormantTable.get(\counterTenorI));
			dic.add("contraTenorO" -> FormantTable.get(\counterTenorO));
			dic.add("contraTenorU" -> FormantTable.get(\counterTenorU));

			dic.add("tenorA" -> FormantTable.get(\tenorA));
			dic.add("tenorE" -> FormantTable.get(\tenorE));
			dic.add("tenorI" -> FormantTable.get(\tenorI));
			dic.add("tenorO" -> FormantTable.get(\tenorO));
			dic.add("tenorU" -> FormantTable.get(\tenorU));

			dic.add("bajoA" -> FormantTable.get(\bassA));
			dic.add("bajoE" -> FormantTable.get(\bassE));
			dic.add("bajoI" -> FormantTable.get(\bassI));
			dic.add("bajoO" -> FormantTable.get(\bassO));
			dic.add("bajoU" -> FormantTable.get(\bassU));
		);

		vocales = this.vocales.toUpper;

		formantes = Array.newClear(vocales.size);
		formantes.size.do{|i| formantes[i]= dic.put[registro++vocales[i]]};

		^formantes
	}



	formantesf{|registro "bajo"|
		var formantes, formantesf;

		formantes= this.formantes(registro);

		formantesf= Array.newClear(5);

		formantesf.size.do{|i| formantesf[i]=Array.newClear(formantes.size)};

		formantes.size.do{|i|
			formantesf.size.do{|x| formantesf[x][i]= formantes[i][0][x]}
		}

		^formantesf
	}

	formantesa{|registro "bajo"|
		var formantes, formantesa;

		formantes= this.formantes(registro);

		formantesa= Array.newClear(5);

		formantesa.size.do{|i| formantesa[i]=Array.newClear(formantes.size)};

		formantes.size.do{|i|
			formantesa.size.do{|x| formantesa[x][i]= formantes[i][1][x]}
		}

		^formantesa
	}

	formantesr{|registro "bajo"|
		var formantes, formantesr;

		formantes= this.formantes(registro);

		formantesr= Array.newClear(5);

		formantesr.size.do{|i| formantesr[i]=Array.newClear(formantes.size)};

		formantes.size.do{|i|
			formantesr.size.do{|x| formantesr[x][i]= formantes[i][2][x]}
		}

		^formantesr
	}


	binario{
		var text;
		text = this.ascii.collect(_.asBinaryDigits).flat;

		^text
	}
}