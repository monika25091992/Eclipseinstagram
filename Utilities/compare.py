from pathlib import Path  # Core Python Module
import sys
import pandas as pd  # pip install pandas openpyxl
import xlwings as xw  # pip install xlwings

# C:\\Users\\shantha.laxmi.kumar\\Desktop\\python\\python.exe Utilities\\compare.py bdlone.xlsx bdlrenamed.xlsx renamed_shantha.xlsx DIFF.xlsx
path = Path.cwd() / "Utilities"/"ExcelReports" / sys.argv[1]
path2 = Path.cwd() / "Utilities"/"ExcelReports" / sys.argv[2]

while True:
    try:
        df = pd.read_excel(path, engine='openpyxl')
    except Exception as e:
        print("Failed to open workbook; error: ")
        print(e)
        wingsbook = xw.Book(path)
        wingsapp = xw.apps.active
        wingsbook.save(path2)
        wingsapp.quit()

        path = path2
    else:
          break
    
for col in df.columns:
    print(col)
    


print(sys.argv[1])
initial_version =  Path.cwd() / "Utilities"/"ExcelBenchmarks" / sys.argv[3]
updated_version =  path

xl = pd.ExcelFile(initial_version)
res = len(xl.sheet_names)
values = range(res)
print(res)

for x in (values):

 # Find the duplicate rows in each sheets and check if the duplicate dataframes are equal

    df_initial = pd.read_excel(initial_version,engine='openpyxl',sheet_name=x)
   # Select duplicate row based on all columns
    df1 = df_initial[df_initial.duplicated(keep=False)]
    print("************")
    print(df1)
    print("************")
    
    df_update = pd.read_excel(updated_version,engine='openpyxl',sheet_name=x)
   # Select duplicate row based on all columns
    df2 = df_update[df_update.duplicated(keep=False)]
    print("************")
    print(df2)
    print("************")
    
    print("Check if duplicate rows from both sheets are same ", df1.equals(df2))

#In each sheet remove duplicates except first occurance and  then check in each what is present in left only and or right only 
    df_initial = pd.read_excel(initial_version, engine='openpyxl',sheet_name=x)
    print(df_initial.shape)
    df_initial.drop_duplicates(keep="first", inplace=True)
    print(df_initial)

    df_update = pd.read_excel(updated_version,engine='openpyxl',sheet_name=x)
    print(df_update.shape)
    df_update.drop_duplicates(keep="first", inplace=True)
    print(df_update)

    print(df_initial.shape == df_update.shape)


    # We need the index information to highlight the rows in Excel
    df_update = df_update.reset_index()
    df_update.head(3)

    df_initial = df_initial.astype(str)
    df_update = df_update.astype(str)
    # Merge dataframes and add inidactor column
    df_diff = pd.merge(df_initial, df_update, how="outer",indicator="Exist")
   


    # Show only the differnce
    df_diff = df_diff.query("Exist != 'both'")
    print(df_diff)
    if x<1:
        df_diff.to_excel(Path.cwd() /"Utilities"/ "DifferenceExcels" /sys.argv[4], sheet_name="Diff_"+ str(x)) 
    else:
        with pd.ExcelWriter(Path.cwd() / "Utilities"/ "DifferenceExcels" /sys.argv[4], mode='a', engine="openpyxl") as writer:
            df_diff.to_excel(writer, sheet_name="Diff_"+ str(x)) 



# self = updated_version
# other = initial_version

"""
print(df_initial)
print(df_update)

# Merge dataframes and add inidactor column
df_diff = pd.merge(df_initial, df_update, how="inner", indicator="Exist")
print(df_diff)

df_diff = df_diff.query("Exist != 'both'")
print(df_diff)
# Show only the data we want to highlight
df_highlight = df_diff.query("Exist == 'right_only'")
print(df_highlight)

# df_diff.to_excel(Path.cwd() / "inputs" /"Difference.xlsx")
"""