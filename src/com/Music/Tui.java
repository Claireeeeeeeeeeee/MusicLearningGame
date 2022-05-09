package com.Music;

public class Tui extends Main {
    static String selected;

    Tui(){
        chooseInstrument();
        select();
    }


    public void chooseInstrument(){
        try {
            for (int i = 0; i <= sound.soundFontPretty.size() - 1; i++) {

                System.out.println("Choose a soundfont:\n" + i + 1 + ":" + " " + sound.soundFontPretty.get(i));
                selected = sound.soundFontPretty.get(input.nextInt() - 1);
                System.out.println("Selected " + selected + "\n");
                //Actually loading the proper sound needs to still be implemented
            }
        }catch(IndexOutOfBoundsException e){
            System.err.println("Index Out Of Bounds: " + e.getMessage() + "\nSoundfont not found");
            chooseInstrument();
        }
    }

    public void select() {
        char select;
        while (true) {
            System.out.println("M: ManualSound\nR: RandomSound\nI: Interval\nQ: Quit");
            select = input.next().toUpperCase().charAt(0);
            switch (select) {
                case 'R' -> sound.playSound(rand.nextInt(88));
                case 'D' -> System.out.println(sound.getPath());
                case 'M' -> sound.playSound();
                case 'Q' -> {
                    System.out.println("Quitting");
                    System.exit(0);
                }
                case 'I' -> interval.playGame();
                default -> System.out.println("Invalid Option\n");
            }
        }
    }
}
