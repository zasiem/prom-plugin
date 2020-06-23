# prom-plugin
ProM 6 Process Mining Plugins

## Plugins
- read event logs (XES File)
- Visualized petrinet from xes using custom algorithm
- Conformance check from petrinet

## Step Create Footprint
1. input xlog, case 1 belajarnya pake array
2. kita ambil masing masing 1 activity nya
3. membuat matriks 2 dimensi
4. setiap matriks diisi pake direct succession jika di array awal ternyata memenuhi syarat
5. bikin matriks 2 dimensi sesuai ukuran no 3
6. mengisi matriks nomor 5 dengan causality atau paralel