package ar.edu.unju.fi.listas;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

@Component
public class ListaConsejo {
	
	private List<Consejo> consejos;
	
	public ListaConsejo() {
	
		consejos = new ArrayList<Consejo>();
		
		consejos.add(new Consejo(1,"PERROS Felices","Te contamos algunos ejercicios cognitivos para aprender jugando y para reforzar así, el vínculo de amor y respeto con tu mascota. Enseñale a tu perro habilidades caninas. /n"+" "+"Favorece su parte del pensamiento, ayuda a la resolución diaria de problemas y también a fomentar el vínculo con sus humanos. /n"+" "+"Podés esneñarle ejercicios como: /n"+" "+"Sentado, Echado, Girar, Trabajo de autocontrol, Dar la pata"));
		consejos.add(new Consejo(2,"Malos Hábitos = Malas Conductas","He aquí una lista de malos hábitos o prácticas que pueden ocasionar que tu perro desarrolle comportamientos no deseados. /n"+" "+"Acariciarlo mientras tiene miedo. Eso solo le comunicará que estar asustado es lo correcto y que tu lo estás premiando por eso./n"+" "+"Darle probaditas de comida. Puede derivar en que tu perro se vuelva “caprichoso” para comer y rechace sus croquetas. También puede dañar su salud. /n"+" "+"Usar su nombre antes o después de un correctivo. ¡Max, NO! Eso hará que relacione su nombre con un regaño o una mala experiencia y cuando quieras que acuda a tu llamado, pensará que algo hizo mal."));
		consejos.add(new Consejo(3,"¿Y si adoptás una mascota adulta?","Existen muchas protectoras en todo el país que hacen un trabajo inmenso para rescatar perros y gatos de la calle. Estos animales que fueron abandonados y sufrieron innumerables maltratos./n"+" "+"Un perro o gato adulto tiene muchas virtudes, como por ejemplo: tienen un carácter ya formado, no van a morder tus zapatillas o arañar los sillones; son más tranquilos y no requieren tanto adiestramiento como un cachorro./n"+" "+"Lo único que necesitan, además de agua, comida y un lugar donde dormir, es AMOR para recuperar la confianza que perdieron luego de años de sufrimiento y desarraigo. Que vos los sumes a tu familia, significa para ellos una segunda oportunidad y todas las personas que conviven con perros y gatos rescatados de la calle coinciden: cuando los adoptás, te lo agradecen para siempre."));
		consejos.add(new Consejo(4,"Mudanzas. Consejos para que sea un éxito","Los cambios de hogar son siempre un estres, para nosotros y para ellos. En esta nota te damos tips para que prepares a tus mascotas para el cambio, y que sea todo un éxito. Para facilitar la transición debemos: /n"+" "+
			"Mantener la rutina de tu perro al máximo y mejor que nunca (los paseos diarios y a la misma hora son vitales). /n"+" "+
			"Preparar el medio de transporte donde viajará y acostumbrarlo al uso de transportadora. /n"+ " " +
			"Practicarle un examen general de salud. /n" + " " +
			"Hacerle una placa de identificación con la dirección de la nueva casa. /n"+" "+
			"No lavar los objetos de tu perro, sino trasladarlos intactos al nuevo hogar para conservar olores importantes para él. /n"+" "+
			"No cambiar ni renovar su cama, cobija y/o casa."));
		consejos.add(new Consejo(5,"Consejos útiles para viajar con tu mascota","Viajar con tu mascota, puede ser una aventura increíble, o una mala experiencia para ambos. /n"+ " "+
			"Si viajas en avión, es fundamental que consultes las condiciones de la aerolínea para el transporte de animales. Generalmente, solicitan certificados de vacunación, constancias de salud firmadas por un veterinario y otros documentos que debes tramitar con anticipación. /n"+" "+
			"Si viajas en tu propio auto, puedes adquirir algunos elementos que pueden hacer más llevadero el viaje, como una tela impermeable para proteger el asiento, arneses adaptables para los cinturones de seguridad, vasijas desechables o un trapo para limpiar la trompa de tu mascota constantemente hay perros que babean mucho. /n"+ " "+
			"Si viajas en transporte terrestre público, es fundamental que hables con el conductor y establezcas las condiciones para transportar a tu mascota. En ocasiones te obligarán a proteger el asiento, ubicarlo en el piso, usar una jaula o alejarlo de los demás pasajeros."));
		
		
	}

	public List<Consejo> getConsejos() {
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

	
}
