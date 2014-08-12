void s_cut() {
    
    System.out.println();
    for(int i=1;i<=l;i++)
        table[i][i]=0;
    
    //Arrays.s
    Arrays.sort(al);

    for(int i=0;i<p;i++) {
        System.out.print(al[i]+ "  ");
    }


    for(int len=2;len<=l;len++) {
        //System.out.println("The length is  "+len);
        for(int i=1,j=i+len-1;j<=l;i++,j++) {
            high= min_index(al,j-1);
            low= max_index(al,i);

            System.out.println("Indices are "+low+"  "+high);
            if(low<=high && low!=-1 && high!=-1) {

                int cost=Integer.MAX_VALUE;;
                for(int k=low;k<=high;k++) {
                    //if(al[k]!=j)
                    temp=cost;
                    cost=Math.min(cost, table[i][al[k]]+table[al[k]+1][j]);

                    if(temp!=cost) {
                        min=k; 
                        //values[i][j].add(al[k]);
                        //values[i][j].addAll(values[i][al[k]]);
                        //values[i][j].addAll(values[al[k]+1][j]);
                        //values[i][j].addAll(values[i][al[k]]);
                    }

                    //else
                    //cost=0;
                }

                table[i][j]= len+cost;

                values[i][j].add(al[min]);
                //values[i][j].addAll(values[i][al[min]]);
                values[i][j].addAll(values[al[min]+1][j]);
                values[i][j].addAll(values[i][al[min]]);
            }
            else
                table[i][j]=0;

            System.out.println(" values are "+i+"  "+j+"  "+table[i][j]);
        }
    }

    System.out.println(" The minimum cost is "+table[1][l]);

    //temp=values[1][l];
    for(int e: values[1][l]) {
        System.out.print(e+"-->");
    }

}