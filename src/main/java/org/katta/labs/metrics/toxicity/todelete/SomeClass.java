package org.katta.labs.metrics.toxicity.todelete;

public class SomeClass {

    private void tooManyIfBlocks() {
        if (true) {
            System.out.println("this is first block");
            if (false) {
                System.out.println("this wont get executed");
                if (false) {
                    System.out.println("this is false");
                    if (true) {
                        System.out.println("last block");
                    }
                }

            }
        }
    }

    private void tooManyIfBlocksSecondMethod() {
        if (true) {
            System.out.println("this is first block");
            if (false) {
                System.out.println("this wont get executed");
                if (false) {
                    System.out.println("this is false");
                    if (true) {
                        System.out.println("last block");
                    }
                }

            }
        }
    }

    private void tooMuchNestedTryBlocks() {
        try {

            try {

                try {

                    try {
                        try {
                            System.out.println("this is the inner most try");

                        } finally {

                        }

                    } finally {

                    }

                } finally {

                }

            } finally {

            }

        } finally {

        }


    }

    private void tooMuchNestedTryBlocksSecond() {
        try {

            try {

                try {

                    try {
                        try {
                            System.out.println("this is the inner most try");

                        } finally {

                        }

                    } finally {

                    }

                } finally {

                }

            } finally {

            }

        } finally {

        }


        int no = 0;
        switch (no) {
            case 1 :
                System.out.println("this is one");
                break;
            case 2:
                System.out.println("this is two");
                break;
        }

    }
}
