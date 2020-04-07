package com.demo;

class Factory {

    void produce() {

        Document d = new Document();
        Printer p = new Printer(d);
        p.print();
    }

    class Printer {

        private DocumentInterface document;

        Printer(DocumentInterface document) {
            this.document = document;
        }

        void print() {
            System.out.println(document.getPage());
        }
    }

    class Document implements DocumentInterface {

        Document() {
        }

        @Override
        public String getPage() {
            return "Page";
        }
    }

    interface DocumentInterface {
        String getPage();
    }

}
