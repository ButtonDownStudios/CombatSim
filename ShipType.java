public enum ShipType{
    DREADNOUGHT,CARRIER,BATTLESHIP,HEAVYCRUISER,LIGHTCRUISER,FRIGATE,GUNSHIP,FREIGHTER,HEAVYFIGHTER,LIGHTFIGHTER,INTERCEPTOR,BOMBER;

    static{
        DREADNOUGHT.setPriorities(
            new ShipType[]{ShipType.DREADNOUGHT,ShipType.CARRIER,ShipType.BATTLESHIP},
            new ShipType[]{ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER},
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP});
        CARRIER.setPriorities(
            new ShipType[]{ShipType.HEAVYFIGHTER,ShipType.LIGHTFIGHTER,ShipType.BOMBER},
            new ShipType[]{ShipType.GUNSHIP,ShipType.INTERCEPTOR},
            new ShipType[]{ShipType.LIGHTCRUISER,ShipType.FRIGATE});
        BATTLESHIP.setPriorities(
            new ShipType[]{ShipType.DREADNOUGHT,ShipType.BATTLESHIP,ShipType.HEAVYCRUISER},
            new ShipType[]{ShipType.CARRIER,ShipType.LIGHTCRUISER,ShipType.FRIGATE},
            new ShipType[]{ShipType.GUNSHIP,ShipType.HEAVYFIGHTER,ShipType.BOMBER});
        HEAVYCRUISER.setPriorities(
            new ShipType[]{ShipType.BATTLESHIP,ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER},
            new ShipType[]{ShipType.DREADNOUGHT,ShipType.CARRIER,ShipType.FRIGATE},
            new ShipType[]{ShipType.GUNSHIP,ShipType.HEAVYFIGHTER,ShipType.BOMBER});
        LIGHTCRUISER.setPriorities(
            new ShipType[]{ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER,ShipType.FRIGATE},
            new ShipType[]{ShipType.CARRIER,ShipType.BATTLESHIP,ShipType.GUNSHIP},
            new ShipType[]{ShipType.HEAVYFIGHTER,ShipType.BOMBER});
        FRIGATE.setPriorities(
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP,ShipType.HEAVYFIGHTER},
            new ShipType[]{ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER,ShipType.BOMBER},
            new ShipType[]{ShipType.BATTLESHIP,ShipType.LIGHTFIGHTER,ShipType.INTERCEPTOR});
        GUNSHIP.setPriorities(
            new ShipType[]{ShipType.LIGHTCRUISER,ShipType.FRIGATE,ShipType.GUNSHIP},
            new ShipType[]{ShipType.FREIGHTER,ShipType.HEAVYFIGHTER,ShipType.BOMBER},
            new ShipType[]{ShipType.LIGHTFIGHTER,ShipType.INTERCEPTOR,ShipType.HEAVYCRUISER});
        FREIGHTER.setPriorities(
            new ShipType[]{ShipType.BOMBER,ShipType.LIGHTFIGHTER,ShipType.INTERCEPTOR},
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP,ShipType.BOMBER},
            new ShipType[]{ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER});
        HEAVYFIGHTER.setPriorities(
            new ShipType[]{ShipType.HEAVYFIGHTER,ShipType.LIGHTFIGHTER,ShipType.BOMBER},
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP,ShipType.INTERCEPTOR},
            new ShipType[]{ShipType.FREIGHTER,ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER});
        LIGHTFIGHTER.setPriorities(
            new ShipType[]{ShipType.HEAVYFIGHTER,ShipType.LIGHTFIGHTER,ShipType.INTERCEPTOR},
            new ShipType[]{ShipType.GUNSHIP,ShipType.BOMBER,ShipType.FREIGHTER},
            new ShipType[]{ShipType.LIGHTCRUISER,ShipType.FRIGATE});
        INTERCEPTOR.setPriorities(
            new ShipType[]{ShipType.HEAVYFIGHTER,ShipType.BOMBER,ShipType.FREIGHTER},
            new ShipType[]{ShipType.LIGHTFIGHTER,ShipType.INTERCEPTOR},
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP});
        BOMBER.setPriorities(
            new ShipType[]{ShipType.DREADNOUGHT,ShipType.CARRIER,ShipType.BATTLESHIP},
            new ShipType[]{ShipType.HEAVYCRUISER,ShipType.LIGHTCRUISER},
            new ShipType[]{ShipType.FRIGATE,ShipType.GUNSHIP,ShipType.FREIGHTER});
    }

    private ShipType[][] priorities;
    private void setPriorities(ShipType[] p1, ShipType[] p2, ShipType[] p3){
        priorities = new ShipType[3][];
        priorities[0] = p1;
        priorities[1] = p2;
        priorities[2] = p3;
    }

    public ShipType[][] getPriority(){
        return priorities;
    }
}
