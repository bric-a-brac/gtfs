package ch.echosystem.gtfs;

public final class Route extends LongName
	{
	public enum Type
		{
		TRAMWAY, // 0
		METRO, // 1
		TRAIN, // 2
		BUS // 3

		/*
			0 : tramway ou métro léger. Tout système de métro léger ou circulant sur la chaussée dans une zone métropolitaine.
			1 : métro. Tout système ferroviaire souterrain circulant au sein d'une zone métropolitaine.
			2 : train. Utilisé pour les trajets interurbains ou longue distance.
			3 : bus. Utilisé pour les lignes de bus courte et longue distance.
			4 : ferry. Utilisé pour le service de bateaux courte et longue distance.
			5 : tramway à traction par câble. Utilisé pour les systèmes de tramways au niveau de la chaussée dans lesquels le câble passe sous le véhicule, comme c'est le cas à San Francisco.
			6 : téléphérique. Service de transport par câble où les cabines, voitures, télécabines ou sièges sont suspendus à l'aide d'un ou de plusieurs câbles.
			7 : funiculaire. Tout système ferroviaire conçu pour les pentes raides.
			11 : trolleybus. Autobus électrique alimenté par des lignes aériennes de contact.
			12 : monorail. Service de chemin de fer roulant sur une voie constituée d'un rail ou d'une poutre unique.
			*/
		}

	private Type type;

	public Type getType()
		{
		return type;
		}
	
	public void setType(final Type type)
		{
		this.type = type;
		}
	}
